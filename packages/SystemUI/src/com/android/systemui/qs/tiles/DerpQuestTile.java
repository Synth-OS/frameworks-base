/*
 * Copyright (C) 2021 Spark-Rom
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

package com.android.systemui.qs.tiles;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.provider.Settings;
import android.service.quicksettings.Tile;
import android.content.ComponentName;
import com.android.internal.logging.nano.MetricsProto.MetricsEvent;
import com.android.systemui.plugins.qs.QSTile.BooleanState;
import com.android.systemui.qs.QSHost;
import com.android.systemui.qs.tileimpl.QSTileImpl;
import com.android.systemui.R;

import javax.inject.Inject;

public class DerpQuestTile extends QSTileImpl<BooleanState> {

    private static final ComponentName DERP_SETTINGS_COMPONENT = new ComponentName(
 "com.android.settings", "com.android.settings.Settings$DerpQuestSettingsActivity");
    private static final Intent DERP_SETTINGS =
            new Intent().setComponent(DERP_SETTINGS_COMPONENT);

    @Inject
    public DerpQuestTile(QSHost host) {
        super(host);
    }

    @Override
    protected void handleClick() {
    }

    @Override
    public Intent getLongClickIntent() {
        return DERP_SETTINGS;
    }

    @Override
    protected void handleUpdateState(BooleanState state, Object arg) {
        state.label = mContext.getString(R.string.quick_settings_derpquest_label);
        state.icon = ResourceIcon.get(R.drawable.ic_qs_derp);
        state.state = Tile.STATE_ACTIVE;
    }

    @Override
    public CharSequence getTileLabel() {
        return mContext.getString(R.string.quick_settings_derpquest_label);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsEvent.DERP;
    }

    @Override
    public BooleanState newTileState() {
        return new BooleanState();
    }

    @Override
    public void handleSetListening(boolean listening) {
        // Do nothing
    }
}
