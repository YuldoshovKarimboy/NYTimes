package com.uz.android.newyorktimes.core.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ArticlePage(
    @SerializedName("status")
    val status: String, // OK
    @SerializedName("copyright")
    val copyright: String, // Copyright (c) 2021 The New York Times Company.  All Rights Reserved.
    @SerializedName("num_results")
    val numResults: Int, // 20
    @SerializedName("results")
    val results: List<Result>
) {
    data class Result(
        @SerializedName("uri")
        val uri: String, // nyt://article/a5c580a1-d38f-5d9c-9ec4-f277779b06f9
        @SerializedName("url")
        val url: String, // https://www.nytimes.com/2021/12/08/health/covid-fat-obesity.html
        @SerializedName("id")
        val id: Long, // 100000008051701
        @SerializedName("asset_id")
        val assetId: Long, // 100000008051701
        @SerializedName("source")
        val source: String, // New York Times
        @SerializedName("published_date")
        val publishedDate: String, // 2021-12-08
        @SerializedName("updated")
        val updated: String, // 2021-12-10 11:32:25
        @SerializedName("section")
        val section: String, // Health
        @SerializedName("subsection")
        val subsection: String,
        @SerializedName("nytdsection")
        val nytdsection: String, // health
        @SerializedName("adx_keywords")
        val adxKeywords: String, // your-feed-science;Obesity;Coronavirus (2019-nCoV);Weight;Immune System;Fat Tissue;Research
        @SerializedName("column")
        val column: Any?, // null
        @SerializedName("byline")
        val byline: String, // By Roni Caryn Rabin
        @SerializedName("type")
        val type: String, // Article
        @SerializedName("title")
        val title: String, // The Coronavirus Attacks Fat Tissue, Scientists Find
        @SerializedName("abstract")
        val `abstract`: String, // The research may help explain why people who are overweight and obese have been at higher risk of severe illness and death from Covid.
        @SerializedName("des_facet")
        val desFacet: List<String>,
        @SerializedName("org_facet")
        val orgFacet: List<String>,
        @SerializedName("per_facet")
        val perFacet: List<String>,
        @SerializedName("geo_facet")
        val geoFacet: List<String>,
        @SerializedName("media")
        val media: List<Media>,
        @SerializedName("eta_id")
        val etaId: Int // 0
    ){
        data class Media(
            @SerializedName("type")
            val type: String, // image
            @SerializedName("subtype")
            val subtype: String, // photo
            @SerializedName("caption")
            val caption: String, // Research has found that the coronavirus infects fat cells and immune cells within body fat, causing an immune response that scientists say may contribute to severe disease.
            @SerializedName("copyright")
            val copyright: String, // Nanographics, via Reuters
            @SerializedName("approved_for_syndication")
            val approvedForSyndication: Int, // 1
            @SerializedName("media-metadata")
            val mediaMetadata: List<MediaMetadata>
        ) {
            data class MediaMetadata(
                @SerializedName("url")
                val url: String, // https://static01.nyt.com/images/2021/12/08/science/08virus-fat/08virus-fat-thumbStandard.jpg
                @SerializedName("format")
                val format: String, // Standard Thumbnail
                @SerializedName("height")
                val height: Int, // 75
                @SerializedName("width")
                val width: Int // 75
            )
        }
    }
}