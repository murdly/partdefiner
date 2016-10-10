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

import android.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

class BindersGenerator<M, V extends View> {

    final List<Pair<SinglePartDefinition<M, V>, Binder<V>>> generateBinders(
            List<M> items, List<PartDefinition<M>> basicGroup) {

        List<Pair<SinglePartDefinition<M, V>, Binder<V>>> binders = new ArrayList<>();

        for (M item : items) {
            List<SinglePartDefinition<M, V>> parts = expandToListOfSingleParts(item, basicGroup);
            binders.addAll(generate(item, parts));
        }

        return binders;
    }

    private List<SinglePartDefinition<M, V>> expandToListOfSingleParts(
            M item, List<PartDefinition<M>> basicGroup) {

        List<SinglePartDefinition<M, V>> list = new ArrayList<>();

        for (PartDefinition<M> part : basicGroup) {
            list.addAll(expandPart(item, part));
        }

        return list;
    }

    private List<SinglePartDefinition<M, V>> expandPart(M item, PartDefinition<M> part) {
        List<SinglePartDefinition<M, V>> list = new ArrayList<>();

        if (part.isNeeded(item)) {
            if (part instanceof GroupPartDefinition) {
                List<PartDefinition<M>> children = ((GroupPartDefinition<M>) part).getChildren(item);
                for (PartDefinition<M> child : children) {
                    list.addAll(expandPart(item, child));
                }
            } else {
                list.add((SinglePartDefinition<M, V>) part);
            }
        }

        return list;
    }

    private List<Pair<SinglePartDefinition<M, V>, Binder<V>>> generate(
            M item, List<SinglePartDefinition<M, V>> singleParts) {

        List<Pair<SinglePartDefinition<M, V>, Binder<V>>> binders = new ArrayList<>();

        for (SinglePartDefinition<M, V> part : singleParts) {
            if (part.isNeeded(item)) {
                Pair<SinglePartDefinition<M, V>, Binder<V>> pair = new Pair<>(part, part.createBinder(item));
                binders.add(pair);
            }
        }

        return binders;
    }
}
