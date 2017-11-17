package com.lethalskillzz.nomoreqs.presentation.custom.splash.utils;


import com.lethalskillzz.nomoreqs.presentation.custom.splash.cnst.Flags;
import com.lethalskillzz.nomoreqs.presentation.custom.splash.model.ConfigSplash;


public class ValidationUtil {

    public static int hasPath(ConfigSplash cs) {
        if (cs.getPathSplash().isEmpty())
            return Flags.WITH_LOGO;
        else
            return Flags.WITH_PATH;
    }
}
