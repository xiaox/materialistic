/*
 * Copyright (c) 2015 Ha Duy Trung
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.hidroh.materialistic.data;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Data repository for {@link Item}
 */
public interface ItemManager {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            TOP_FETCH_MODE,
            NEW_FETCH_MODE,
            ASK_FETCH_MODE,
            SHOW_FETCH_MODE,
            JOBS_FETCH_MODE
    })
    @interface FetchMode {}
    String TOP_FETCH_MODE = "top";
    String NEW_FETCH_MODE = "new";
    String ASK_FETCH_MODE = "ask";
    String SHOW_FETCH_MODE = "show";
    String JOBS_FETCH_MODE = "jobs";

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            MODE_DEFAULT,
            MODE_CACHE,
            MODE_NETWORK
    })
    @interface CacheMode {}
    int MODE_DEFAULT = 0;
    int MODE_CACHE =1;
    int MODE_NETWORK = 2;

    /**
     * Gets array of top stories
     * @param filter    filter of stories to fetch
     * @param listener  callback to be notified on response
     */
    void getStories(String filter, final ResponseListener<Item[]> listener);

    /**
     * Gets individual item by ID
     * @param itemId        item ID
     * @param cacheMode     cache mode,
     * @param listener      callback to be notified on response
     */
    void getItem(String itemId, @CacheMode int cacheMode, ResponseListener<Item> listener);

}
