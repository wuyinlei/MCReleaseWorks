/*
 * Copyright 2016 drakeet. https://github.com/drakeet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mingchu.mcreleaseworks;

import me.drakeet.multitype.GlobalMultiTypePool;

class MultiTypeInstaller {

    static void start() {
//        GlobalMultiTypePool.register(TextItem.class, new TextItemViewProvider());
        GlobalMultiTypePool.register(UpLoadFoodMessage.class,new FoodValueItemViewProviderThree());
        GlobalMultiTypePool.register(UpLoadFoodMessage.class,new FoodValueItemViewProviderTwo());
        GlobalMultiTypePool.register(UpLoadFoodMessage.class,new FoodValueItemViewProviderOne());
        GlobalMultiTypePool.register(UpLoadFoodMessage.class, new FoodValueItemViewProvider());
        GlobalMultiTypePool.register(Category.class, new CategoryItemViewProvider());
    }
}
