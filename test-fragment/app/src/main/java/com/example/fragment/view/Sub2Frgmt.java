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

package com.example.fragment.view;

import android.widget.TextView;

import com.example.fragment.R;

import net.sarangnamu.common.FrgmtBase;

import butterknife.BindView;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2016. 10. 7.. <p/>
 */
public class Sub2Frgmt extends FrgmtBase{
    private static final org.slf4j.Logger mLog = org.slf4j.LoggerFactory.getLogger(Sub2Frgmt.class);

    @BindView(R.id.textView)
    TextView mName;

    @Override
    protected int getLayoutId() {
        return R.layout.frgmt_sub2;
    }

    @Override
    protected void initLayout() {
        mLog.debug("LOAD : " + getClass().getSimpleName());

        mName.setText(getClass().getSimpleName());
    }
}
