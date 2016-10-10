/*
 * Copyright (c) 2016 Arkadiusz Karbowy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.akarbowy.partdefiner;

import android.support.annotation.NonNull;
import android.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class PartManager<M> {

    private List<PartDefinition<M>> basicPartDefinition;
    private List<Pair<SinglePartDefinition<M, View>, Binder<View>>> binders;
    private BindersGenerator<M, View> generator;

    public PartManager() {
        basicPartDefinition = new ArrayList<>();
        binders = new ArrayList<>();
        generator = new BindersGenerator<>();
    }

    public void add(@NonNull PartDefinition<M> definition) {
        if (definition == null) {
            throw new NullPointerException("Part definition is null.");
        }

        basicPartDefinition.add(definition);
    }

    public void setItemsForBinding(@NonNull List<M> items) {
        if (items == null) {
            throw new NullPointerException("Items source is null.");
        }

        binders.addAll(generator.generateBinders(items, basicPartDefinition));
    }

    public int getItemViewType(int position) {
        if (position > binders.size()) {
            throw new IllegalArgumentException("No binder associated with part at this position."
                    + " Binders: " + binders.size()
                    + " Position: " + position);
        }

        return binders.get(position).first.getViewType();
    }

    public Binder<View> getBinder(int position) {
        if (position > binders.size()) {
            throw new IllegalArgumentException("No binder associated with part at this position."
                    + " Binders: " + binders.size()
                    + " Position: " + position);
        }


        return binders.get(position).second;
    }

    public int getItemCount() {
        return binders.size();
    }

    public void clearBinders() {
        binders.clear();
    }
}
