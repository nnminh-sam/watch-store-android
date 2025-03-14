package nnminh.playground.watchstoreandroid.data.model;

import java.io.Serializable;

public class Category implements Serializable {
    private String name;

    private String slug;

    private String assetUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getAssetUrl() {
        return assetUrl;
    }

    public void setAssetUrl(String assetUrl) {
        this.assetUrl = assetUrl;
    }

    public Category(String name, String slug, String assetUrl) {
        this.name = name;
        this.slug = slug;
        this.assetUrl = assetUrl;
    }
}
