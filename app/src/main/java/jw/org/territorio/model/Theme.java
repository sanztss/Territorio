package jw.org.territorio.model;

import android.support.annotation.ColorRes;
import android.support.annotation.StyleRes;

import jw.org.territorio.R;

/**
 * Created by Des. Android on 27/07/2017.
 */

public enum Theme {
    blue(R.color.bluePrimary, R.color.bluePrimaryDark,
            R.color.blueBackground, R.color.blueText,
            R.color.blueAccent, R.style.AppTheme),
    green(R.color.greenPrimary, R.color.greenPrimaryDark,
            R.color.greenBackground, R.color.greenText,
            R.color.greenAccent, R.style.AppTheme),
    pink(R.color.pinkPrimary, R.color.pinkPrimaryDark,
            R.color.pinkBackground, R.color.pinkText,
            R.color.pinkAccent, R.style.AppTheme),
    orange(R.color.orangePrimary, R.color.orangePrimaryDark,
            R.color.orangeBackground, R.color.orangeText,
            R.color.orangeAccent, R.style.AppTheme),
    yellow(R.color.yellowPrimary, R.color.yellowPrimaryDark,
            R.color.yellowBackground, R.color.yellowText,
            R.color.yellowAccent, R.style.AppTheme);

    private final int mColorPrimaryId;
    private final int mWindowBackgroundColorId;
    private final int mColorPrimaryDarkId;
    private final int mTextColorPrimaryId;
    private final int mAccentColorId;
    private final int mStyleId;

    Theme(final int colorPrimaryId, final int colorPrimaryDarkId,
          final int windowBackgroundColorId, final int textColorPrimaryId,
          final int accentColorId, final int styleId) {
        mColorPrimaryId = colorPrimaryId;
        mWindowBackgroundColorId = windowBackgroundColorId;
        mColorPrimaryDarkId = colorPrimaryDarkId;
        mTextColorPrimaryId = textColorPrimaryId;
        mAccentColorId = accentColorId;
        mStyleId = styleId;
    }

    @ColorRes
    public int getTextPrimaryColor() {
        return mTextColorPrimaryId;
    }

    @ColorRes
    public int getWindowBackgroundColor() {
        return mWindowBackgroundColorId;
    }

    @ColorRes
    public int getPrimaryColor() {
        return mColorPrimaryId;
    }

    @ColorRes
    public int getAccentColor() {
        return mAccentColorId;
    }

    @ColorRes
    public int getPrimaryDarkColor() {
        return mColorPrimaryDarkId;
    }

    @StyleRes
    public int getStyleId() {
        return mStyleId;
    }
}

