package com.example.test.forif_class;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import data.model.BoxOfficeResult;
import data.model.DailyBoxOfficeList;
import data.model.Wrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Koo on 2017-10-12.
 */

public class MovieActivity extends AppCompatActivity {

    TextView test;
    ListView movie_list;

    Wrapper wrapper;
    BoxOfficeResult boxOfficeResult;
    List<DailyBoxOfficeList> dailyBoxOfficeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie);

        // 상태바 흰색 + 최상단바 회색으로 만들기
        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        movie_list = (ListView) findViewById(R.id.movie_list);


        Retrofit retrofit = new Retrofit.Builder().baseUrl(MovieInfoInterface.movie_url)
                .addConverterFactory(GsonConverterFactory.create()).build();
        MovieInfoInterface movieInfoInterface = retrofit.create(MovieInfoInterface.class);

        String key = "e09b2ceaa3de107e1477b9a9d770e6f5";
        String targetDt = "20171012";

        Call<Wrapper> getRequest = movieInfoInterface.getMovieInfo(key, targetDt);

        getRequest.enqueue(new Callback<Wrapper>() {
            @Override
            public void onResponse(Call<Wrapper> call, Response<Wrapper> response) {
                wrapper = response.body();
                boxOfficeResult = wrapper.getBoxOfficeResult();
                dailyBoxOfficeList = boxOfficeResult.getDailyBoxOfficeList();

                MovieAdapter movieAdapter = new MovieAdapter(dailyBoxOfficeList);
                movie_list.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<Wrapper> call, Throwable t) {
            }
        });
    }

    public interface MovieInfoInterface {
        public static final String movie_url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/";
        @GET("searchDailyBoxOfficeList.json")
        Call<Wrapper> getMovieInfo(@Query("key") String key, @Query("targetDt") String date);
    }
}
