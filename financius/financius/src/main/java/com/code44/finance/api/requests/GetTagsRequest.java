package com.code44.finance.api.requests;

import android.content.Context;
import android.net.Uri;

import com.code44.finance.api.User;
import com.code44.finance.backend.endpoint.tags.Tags;
import com.code44.finance.backend.endpoint.tags.model.TagEntity;
import com.code44.finance.common.utils.Preconditions;
import com.code44.finance.data.model.Model;
import com.code44.finance.data.providers.TagsProvider;

import java.util.List;

public class GetTagsRequest extends GetRequest<TagEntity> {
    private final Tags tagsService;

    public GetTagsRequest(Context context, User user, Tags tagsService) {
        super(null, context, user);
        Preconditions.notNull(tagsService, "Tags service cannot be null.");

        this.tagsService = tagsService;
    }

    @Override protected long getLastTimestamp(User user) {
        return user.getCategoriesTimestamp();
    }

    @Override protected List<TagEntity> performRequest(long timestamp) throws Exception {
        return tagsService.list(timestamp).execute().getItems();
    }

    @Override protected Model getModelFrom(TagEntity entity) {
        return null;
    }

    @Override protected void saveNewTimestamp(User user, long newTimestamp) {
        user.setTagsTimestamp(newTimestamp);
    }

    @Override protected Uri getSaveUri() {
        return TagsProvider.uriTags();
    }
}
