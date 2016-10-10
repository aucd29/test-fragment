/*
 * Copyright (C) Hanwha S&C Ltd., 2016. All rights reserved.
 *
 * This software is covered by the license agreement between
 * the end user and Hanwha S&C Ltd., and may be
 * used and copied only in accordance with the terms of the
 * said agreement.
 *
 * Hanwha S&C Ltd., assumes no responsibility or
 * liability for any errors or inaccuracies in this software,
 * or any consequential, incidental or indirect damage arising
 * out of the use of the software.
 */

package com.example.fragment.control;

import net.sarangnamu.common.frgmt.FrgmtManager;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2016. 10. 7.. <p/>
 */
public class ViewManager extends FrgmtManager {
    private static ViewManager mInst;

    public static ViewManager getInstance() {
        if (mInst == null) {
            mInst = new ViewManager();
        }

        return mInst;
    }

    private ViewManager() {

    }
}
