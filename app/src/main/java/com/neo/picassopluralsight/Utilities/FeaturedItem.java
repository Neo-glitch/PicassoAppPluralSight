package com.neo.picassopluralsight.Utilities;

public class FeaturedItem {

    private String imageUrl;
    private String name;
    private String description;

    public FeaturedItem(String imageUrl, String name, String description) {
        super();
        this.imageUrl = imageUrl;
        this.name = name;
        this.description = description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}