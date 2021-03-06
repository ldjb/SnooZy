/*
    SnooZy Charger
    Power Connection manager. Turn the screen off on power connection
    or disconnection, to save battery consumption by the phone's display.

    Copyright (C) 2013 Mudar Noufal <mn@mudar.ca>

    This file is part of SnooZy Charger.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ca.mudar.snoozy.model;

import android.util.SparseArray;

import ca.mudar.snoozy.util.LogUtils;

public class SectionsArray extends SparseArray<HistorySection> {
    private static final String TAG = LogUtils.makeLogTag(SectionsArray.class);

    public int getRawPosition(int position) {
        final int size = size();
        for (int i = 0; i < size; i++) {
            HistorySection section = valueAt(i);
            if (section.contains(position)) {
                return section.computeRawPosition(position);
            }
        }

        return -1;
    }

    public boolean isHeader(int position) {
        final int size = size();
        for (int i = 0; i < size; i++) {
            HistorySection section = valueAt(i);
            if (section.contains(position)) {
                return section.isHeader(position);
            }
        }

        return false;
    }

    public int getHeaderPosition(int position) {
        final int size = size();
        for (int i = 0; i < size; i++) {
            HistorySection section = valueAt(i);
            if (section.contains(position)) {
                return section.getHeaderPosition();
            }
        }

        return 0; // If not found, default to first
    }
}
