package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    String backdrop_path;
    String poster_path;
    String original_title;
    String overview;
    double rating;
    int id;

    public Movie(){}

    public double getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public Movie(JSONObject jsonObject) throws JSONException {
        backdrop_path = jsonObject.getString("backdrop_path");
        poster_path = jsonObject.getString("poster_path");
        original_title = jsonObject.getString("original_title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        id = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i=0; i<movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getBackdrop_path() {
        return String.format("https://image.tmdb.org/t/p/w342%s", backdrop_path);
    }
    public String getPoster_path() {
        return String.format("https://image.tmdb.org/t/p/w342%s", poster_path);
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }
}
