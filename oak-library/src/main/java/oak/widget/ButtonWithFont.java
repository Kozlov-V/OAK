/*
 * Copyright (c) 2011. WillowTree Apps
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package oak.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

import oak.OAK;
import oak.util.OakUtils;

/**
 * User: Michael Lake Date: 11/21/11 Time: 5:36 PM
 */
public class ButtonWithFont extends Button {

    private static final String TAG = ButtonWithFont.class.getSimpleName();

    public ButtonWithFont(Context context) {
        super(context);
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }

    public ButtonWithFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);

        setFont(context, attrs);
    }

    public ButtonWithFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);

        setFont(context, attrs);
    }

    private void setFont(Context context, AttributeSet attrs) {
        String fontName = null;
        if (attrs != null) {
            try {
                fontName = attrs.getAttributeValue(OAK.XMLNS, "font");

                if (fontName != null) {
                    setTypeface(OakUtils.getStaticTypeFace(context, fontName));
                }
            } catch (IllegalArgumentException e) {
                try {
                    int fontNameRes = attrs.getAttributeResourceValue(OAK.XMLNS, "font", -1);
                    if (fontNameRes != -1) {
                        fontName = context.getString(fontNameRes);
                        if (fontName != null) {
                            setTypeface(OakUtils.getStaticTypeFace(context, fontName));
                        }
                    }
                } catch (IllegalArgumentException f) {
                    f.printStackTrace();
                }
            }
        }
    }
}
