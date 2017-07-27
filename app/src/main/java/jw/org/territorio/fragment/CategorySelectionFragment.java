package jw.org.territorio.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jw.org.territorio.R;
import jw.org.territorio.adapter.TerritorioAdapter;
import jw.org.territorio.helper.TransitionHelper;
import jw.org.territorio.model.Territorio;
import jw.org.territorio.model.Theme;
import jw.org.territorio.widget.OffsetDecoration;

import static android.R.attr.data;

/**
 * Created by Des. Android on 26/07/2017.
 */

public class CategorySelectionFragment extends Fragment {

    private TerritorioAdapter mAdapter;
    private Resources mResources;
    private Activity mActivity;
    private Context mContext;

    private List<Territorio> territorios;

    public static CategorySelectionFragment newInstance() {
        return new CategorySelectionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        mContext = mActivity.getApplicationContext();
        mResources = mActivity.getResources();
        return inflater.inflate(R.layout.fragment_territorios, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setUpQuizGrid((RecyclerView) view.findViewById(R.id.categories));
        super.onViewCreated(view, savedInstanceState);
    }

    private void setUpQuizGrid(final RecyclerView categoriesView) {
        final int spacing = getContext().getResources()
                .getDimensionPixelSize(R.dimen.spacing_nano);
        categoriesView.addItemDecoration(new OffsetDecoration(spacing));
        mAdapter = new TerritorioAdapter(getActivity(), getData());
        mAdapter.setOnItemClickListener(
                new TerritorioAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(View v, int position) {
                        Activity activity = getActivity();
                        startQuizActivityWithTransition(activity,
                                v.findViewById(R.id.category_title),
                                mAdapter.getItem(position));
                    }
                });
        categoriesView.setAdapter(mAdapter);
        categoriesView.getViewTreeObserver()
                .addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        categoriesView.getViewTreeObserver().removeOnPreDrawListener(this);
                        getActivity().supportStartPostponedEnterTransition();
                        return true;
                    }
                });
    }

    private List<Territorio> getData() {
        territorios = new ArrayList<>();
        /*for (int i = 1; i <= 6; i++) {
            Territorio territorio = new Territorio();
            territorio.setNumeroTerritorio(i + "");
            territorio.setTematerritorio(Theme.yellow);
            territorios.add(territorio);

        }*/
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(readTerritoriosFromResources());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject territorioJSONObject;
        for (int i = 0; i < jsonArray.length(); i++) {
            Territorio territorio = new Territorio();
            try {
                territorioJSONObject = jsonArray.getJSONObject(i);
                Log.e("AAAAA", "" + territorioJSONObject.get("numero"));
                territorio.setNumeroTerritorio(territorioJSONObject.get("numero").toString());
                switch (territorioJSONObject.get("tema").toString()){
                    case "yellow":
                        territorio.setTematerritorio(Theme.yellow);
                        break;
                    case "pink":
                        territorio.setTematerritorio(Theme.pink);
                        break;
                    case "blue":
                        territorio.setTematerritorio(Theme.blue);
                        break;
                    case "green":
                        territorio.setTematerritorio(Theme.green);
                        break;
                    case "orange":
                        territorio.setTematerritorio(Theme.orange);
                        break;
                    default:
                        break;
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            territorios.add(territorio);
        }
        return territorios;
    }

    private String readTerritoriosFromResources() throws IOException {
        StringBuilder territoriosJson = new StringBuilder();
        InputStream rawTerritorios = mResources.openRawResource(R.raw.territorios);
        BufferedReader reader = new BufferedReader(new InputStreamReader(rawTerritorios));
        String line;

        while ((line = reader.readLine()) != null) {
            territoriosJson.append(line);
        }
        return territoriosJson.toString();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void startQuizActivityWithTransition(Activity activity, View toolbar,
                                                 Territorio territorio) {

        final Pair[] pairs = TransitionHelper.createSafeTransitionParticipants(activity, false,
                new Pair<>(toolbar, "ToolbarTransition"));
        @SuppressWarnings("unchecked")
        ActivityOptionsCompat sceneTransitionAnimation = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity, pairs);

        /*final Bundle transitionBundle = sceneTransitionAnimation.toBundle();
        Intent startIntent = QuizActivity.getStartIntent(activity, territorio);
        ActivityCompat.startActivityForResult(activity,
                startIntent,
                REQUEST_CATEGORY,
                transitionBundle);*/
    }

}
