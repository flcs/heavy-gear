package br.com.bcunha.heavygear.model.pojo;

import com.google.gson.annotations.SerializedName;


/**
 * Created by BRUNO on 16/10/2016.
 */

public class RespostaQuote {

    public RespostaQuote(Query query) {
        this.query = query;
    }

    @SerializedName("query")
    public Query getQuery() {
        return this.query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    Query query;
}


