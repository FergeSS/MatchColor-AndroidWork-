package com.maranvimos.cozilaniven;

import static com.maranvimos.cozilaniven.Settings.action;
import static com.maranvimos.cozilaniven.Settings.fireworkSound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.maranvimos.cozilaniven.databinding.ActivityGameBinding;
import com.maranvimos.cozilaniven.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private ActivityGameBinding binding;
    public static boolean active = false;
    private boolean isGame = false;
    private int level = 1;
    private int click = 0;
    int[] prevCoord = null;
    int[] coordBall1 = new int[2];
    int[] coordBall2 = new int[2];
    int[] coordBall3 = new int[2];
    int[] coordBall4 = new int[2];
    int[] coordBall5 = new int[2];
    int[] coordBall6 = new int[2];
    Dialog dialog = null;
    List<Integer> lines = new ArrayList<Integer>();

    List<Integer> saturations = Arrays.asList(0, 1, 2, 3, 4, 5);
    Integer[] violet = new Integer[] {R.drawable.violet01, R.drawable.violet02, R.drawable.violet03, R.drawable.violet04, R.drawable.violet05, R.drawable.violet06};
    Integer[] blue = new Integer[] {R.drawable.blue01, R.drawable.blue02, R.drawable.blue03, R.drawable.blue04, R.drawable.blue05, R.drawable.blue06};
    Integer[] pink = new Integer[] {R.drawable.pink01, R.drawable.pink02, R.drawable.pink03, R.drawable.pink04, R.drawable.pink05, R.drawable.pink06};
    Integer[] coral = new Integer[] {R.drawable.coral01, R.drawable.coral02, R.drawable.coral03, R.drawable.coral04, R.drawable.coral05, R.drawable.coral06};
    Integer[] yellow_orange = new Integer[] {R.drawable.yellow_orange01, R.drawable.yellow_orange02, R.drawable.yellow_orange03, R.drawable.yellow_orange04, R.drawable.yellow_orange05, R.drawable.yellow_orange06};
    Integer[] green = new Integer[] {R.drawable.green01, R.drawable.green02, R.drawable.green03, R.drawable.green04, R.drawable.green05, R.drawable.green06};
    List<Integer[]> colors = Arrays.asList(violet, blue, pink, coral, yellow_orange, green);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        audioSettings();
        windowSettings();
        gameSettings();
        dialogSettings();
        active = true;
        setLevel(level);
    }

    private void getCoord() {
        binding.row1col1.getLocationInWindow(coordBall1);
        coordBall1[0] += binding.row1col1.getWidth() / 2;
        coordBall1[1] += binding.row1col1.getWidth() / 2;
        binding.row1col2.getLocationInWindow(coordBall2);
        coordBall2[0] += binding.row1col1.getWidth() / 2;
        coordBall2[1] += binding.row1col1.getWidth() / 2;
        binding.row2col1.getLocationInWindow(coordBall3);
        coordBall3[0] += binding.row1col1.getWidth() / 2;
        coordBall3[1] += binding.row1col1.getWidth() / 2;
        binding.row2col2.getLocationInWindow(coordBall4);
        coordBall4[0] += binding.row1col1.getWidth() / 2;
        coordBall4[1] += binding.row1col1.getWidth() / 2;
        binding.row3col1.getLocationInWindow(coordBall5);
        coordBall5[0] += binding.row1col1.getWidth() / 2;
        coordBall5[1] += binding.row1col1.getWidth() / 2;
        binding.row3col2.getLocationInWindow(coordBall6);
        coordBall6[0] += binding.row1col1.getWidth() / 2;
        coordBall6[1] += binding.row1col1.getWidth() / 2;
    }

    private void deleteLines() {
        for (Integer i : lines) {
            binding.getRoot().removeView(binding.getRoot().getViewById(i.intValue()));
        }
    }
    private void clickBall1(View v) {
        action(GameActivity.this);
        if (!isGame) {
            return;
        }
        if (click == 6) {
            return;
        }
        if (click != saturations.get(0)) {
            deleteLines();
            click = 0;
            prevCoord = null;
            return;
        }
        if (prevCoord != null) {
            drawLine(prevCoord[0], prevCoord[1], coordBall1[0], coordBall1[1]);
        }
        ++click;

        if (click == 6) {
            salut();
            return;
        }
        prevCoord = coordBall1.clone();
        return;
    }

    private void clickBall2(View v) {
        action(GameActivity.this);
        if (!isGame) {
            return;
        }
        if (click == 6) {
            return;
        }
        if (click != saturations.get(1)) {
            deleteLines();
            click = 0;
            prevCoord = null;
            return;
        }
        if (prevCoord != null) {

            drawLine(prevCoord[0], prevCoord[1], coordBall2[0], coordBall2[1]);
        }
        ++click;
        if (click > 6) {
            return;
        }
        if (click == 6) {
            salut();
            return;
        }
        prevCoord = coordBall2.clone();
        return;
    }

    private void clickBall3(View v) {
        action(GameActivity.this);
        if (!isGame) {
            return;
        }
        if (click == 6) {
            return;
        }
        if (click != saturations.get(2)) {
            deleteLines();
            click = 0;
            prevCoord = null;
            return;
        }
        if (prevCoord != null) {
            drawLine(prevCoord[0], prevCoord[1], coordBall3[0], coordBall3[1]);
        }
        ++click;

        if (click == 6) {
            salut();
            return;
        }
        prevCoord = coordBall3.clone();
        return;
    }

    private void clickBall4(View v) {
        action(GameActivity.this);
        if (!isGame) {
            return;
        }
        if (click == 6) {
            return;
        }
        if (click != saturations.get(3)) {
            deleteLines();
            click = 0;
            prevCoord = null;
            return;
        }
        if (prevCoord != null) {
            drawLine(prevCoord[0], prevCoord[1], coordBall4[0], coordBall4[1]);
        }
        ++click;

        if (click == 6) {
            salut();
            return;
        }
        prevCoord = coordBall4.clone();
        return;
    }

    private void clickBall5(View v) {
        action(GameActivity.this);
        if (!isGame) {
            return;
        }
        if (click == 6) {
            return;
        }
        if (click != saturations.get(4)) {
            deleteLines();
            click = 0;
            prevCoord = null;
            return;
        }
        if (prevCoord != null) {
            drawLine(prevCoord[0], prevCoord[1], coordBall5[0], coordBall5[1]);
        }
        ++click;

        if (click == 6) {
            salut();
            return;
        }
        prevCoord = coordBall5.clone();
        return;
    }

    private void clickBall6(View v) {
        action(GameActivity.this);
        if (!isGame) {
            return;
        }
        if (click == 6) {
            return;
        }
        if (click != saturations.get(5)) {
            deleteLines();
            click = 0;
            prevCoord = null;
            return;
        }
        if (prevCoord != null) {
            drawLine(prevCoord[0], prevCoord[1], coordBall6[0], coordBall6[1]);
        }
        ++click;
        if (click == 6) {
            salut();
            return;
        }
        prevCoord = coordBall6.clone();
        return;
    }
    private void gameSettings() {
        Collections.shuffle(saturations);
        Collections.shuffle(colors);

        binding.row1col1.setOnClickListener(v -> clickBall1(v));
        binding.row1col2.setOnClickListener(v -> clickBall2(v));
        binding.row2col1.setOnClickListener(v -> clickBall3(v));
        binding.row2col2.setOnClickListener(v -> clickBall4(v));
        binding.row3col1.setOnClickListener(v -> clickBall5(v));
        binding.row3col2.setOnClickListener(v -> clickBall6(v));
    }

    private void setLevel(int level) {
        if (!isGame) {
            binding.hint.animate().alpha(0.0f).setDuration(4000);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isGame = true;
                    getCoord();
                }
            }, 4000);
        }
        if (level >= 7) {
            binding.level6.setImageResource(R.drawable.done);
            if (dialog != null) {
                dialog.show();
            }
            return;
        }
        Collections.shuffle(saturations);
        binding.row1col1.setImageResource(colors.get(level - 1)[saturations.get(0)]);
        binding.row1col2.setImageResource(colors.get(level - 1)[saturations.get(1)]);
        binding.row2col1.setImageResource(colors.get(level - 1)[saturations.get(2)]);
        binding.row2col2.setImageResource(colors.get(level - 1)[saturations.get(3)]);
        binding.row3col1.setImageResource(colors.get(level - 1)[saturations.get(4)]);
        binding.row3col2.setImageResource(colors.get(level - 1)[saturations.get(5)]);

        if (level == 2) {
            binding.level1.setImageResource(R.drawable.done);
            binding.level2.setImageResource(R.drawable.active);
        }
        if (level == 3) {
            binding.level2.setImageResource(R.drawable.done);
            binding.level3.setImageResource(R.drawable.active);
        }
        if (level == 4) {
            binding.level3.setImageResource(R.drawable.done);
            binding.level4.setImageResource(R.drawable.active);
        }
        if (level == 5) {
            binding.level4.setImageResource(R.drawable.done);
            binding.level5.setImageResource(R.drawable.active);
        }
        if (level == 6) {
            binding.level5.setImageResource(R.drawable.done);
            binding.level6.setImageResource(R.drawable.active);
        }
        return;

    }
    private void drawLine(float x1, float y1, float x2, float y2) {
        // Создаем новый LineView
        LineView lineView = new LineView(this);
        lineView.setZ(1);
        lineView.setLine(x1, y1, x2, y2); // Устанавливаем координаты двух точек

        // Задаем ID для LineView (требуется для ConstraintLayout)
        lineView.setId(View.generateViewId());
        lines.add(lineView.getId());

        // Добавляем LineView в ConstraintLayout
        binding.getRoot().addView(lineView, 0, 0); // Размеры будут установлены позже через ограничения

        // Устанавливаем ограничения
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(binding.getRoot());

        // Задаем ограничения для lineView
        constraintSet.connect(lineView.getId(), ConstraintSet.TOP, binding.getRoot().getId(), ConstraintSet.TOP);
        constraintSet.connect(lineView.getId(), ConstraintSet.START, binding.getRoot().getId(), ConstraintSet.START);
        constraintSet.connect(lineView.getId(), ConstraintSet.END, binding.getRoot().getId(), ConstraintSet.END);
        constraintSet.connect(lineView.getId(), ConstraintSet.BOTTOM, binding.getRoot().getId(), ConstraintSet.BOTTOM);

        constraintSet.constrainHeight(lineView.getId(),binding.getRoot().getHeight());
        constraintSet.constrainWidth(lineView.getId(), binding.getRoot().getWidth());

        constraintSet.applyTo(binding.getRoot());
    }

    public void audioSettings() {
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
    }

    public void windowSettings() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.linearLayout2.setZ(2);
    }

    private void dialogSettings() {
        dialog = new Dialog(GameActivity.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        WindowManager.LayoutParams wlp = dialog.getWindow().getAttributes();
        wlp.dimAmount = 0.7f;
        dialog.getWindow().setAttributes(wlp);
        dialog.setContentView(R.layout.dialog);
    }

    @Override public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    public void home(View v) {
        action(GameActivity.this);
        finish();
    }

    public void replay(View v) {
        click = 0;
        level = 1;
        setLevel(1);
        binding.level1.setImageResource(R.drawable.active);
        binding.level2.setImageResource(R.drawable.no_active);
        binding.level3.setImageResource(R.drawable.no_active);
        binding.level4.setImageResource(R.drawable.no_active);
        binding.level5.setImageResource(R.drawable.no_active);
        binding.level6.setImageResource(R.drawable.no_active);
        dialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        active = false;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private void salut() {
        binding.salut1.setZ(3);
        binding.salut1.setX(new Random().nextInt(binding.getRoot().getWidth() - binding.salut1.getWidth()));
        binding.salut1.setY(new Random().nextInt(binding.getRoot().getHeight() - binding.salut1.getHeight()));
        binding.salut1.animate().scaleY(1.0f).scaleX(1.0f).setDuration(500);
        fireworkSound(binding.getRoot().getContext());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.salut2.setZ(3);
                binding.salut2.setX(new Random().nextInt(binding.getRoot().getWidth() - binding.salut1.getWidth()));
                binding.salut2.setY(new Random().nextInt(binding.getRoot().getHeight() - binding.salut1.getHeight()));
                binding.salut2.animate().scaleY(1.0f).scaleX(1.0f).setDuration(500);
                fireworkSound(binding.getRoot().getContext());
                binding.salut1.animate().alpha(0.0f).setDuration(100);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.salut3.setZ(3);
                        binding.salut3.setX(new Random().nextInt(binding.getRoot().getWidth() - binding.salut1.getWidth()));
                        binding.salut3.setY(new Random().nextInt(binding.getRoot().getHeight() - binding.salut1.getHeight()));
                        binding.salut3.animate().scaleY(1.0f).scaleX(1.0f).setDuration(500);
                        fireworkSound(binding.getRoot().getContext());
                        binding.salut2.animate().alpha(0.0f).setDuration(100);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                binding.salut4.setZ(3);
                                binding.salut4.setX(new Random().nextInt(binding.getRoot().getWidth() - binding.salut1.getWidth()));
                                binding.salut4.setY(new Random().nextInt(binding.getRoot().getHeight() - binding.salut1.getHeight()));
                                binding.salut4.animate().scaleY(1.0f).scaleX(1.0f).setDuration(500);
                                fireworkSound(binding.getRoot().getContext());
                                binding.salut3.animate().alpha(0.0f).setDuration(100);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        setLevel(++level);
                                        click = 0;
                                        prevCoord = null;
                                        deleteLines();
                                        binding.salut1.animate().scaleY(0.0f).scaleX(0.0f).setDuration(0);
                                        binding.salut2.animate().scaleY(0.0f).scaleX(0.0f).setDuration(0);
                                        binding.salut3.animate().scaleY(0.0f).scaleX(0.0f).setDuration(0);
                                        binding.salut4.animate().alpha(0.0f).setDuration(100);
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                binding.salut4.animate().scaleY(0.0f).scaleX(0.0f).setDuration(0);
                                                binding.salut1.setAlpha(1.0f);
                                                binding.salut2.setAlpha(1.0f);
                                                binding.salut3.setAlpha(1.0f);
                                                binding.salut4.setAlpha(1.0f);
                                            }
                                        }, 500);

                                    }
                                }, 500);
                            }
                        },500);
                    }
                },500);
            }
        },500);


    }
}

