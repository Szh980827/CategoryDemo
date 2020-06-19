package com.zhihao.category;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private List<String> menuList;                  // 左侧标题list
	private List<CategoryBean.DataBean> homeList;   // 右侧商品列表list
	private List<Integer> showTitle;                // 标题总数

	private ListView lv_menu;       // 左侧标题ListView
	private ListView lv_home;       // 右侧商品ListView

	private LeftAdapter leftAdapter;
	private RightAdapter rightAdapter;
	private int currentItem;

//	private TextView tv_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Fresco.initialize(this);
		initView();
		loadData();
	}

	private void initView() {
		lv_menu = findViewById(R.id.lv_menu);
//		tv_title = findViewById(R.id.tv_titile);
		lv_home = findViewById(R.id.lv_home);

		showTitle = new ArrayList<>();
		menuList = new ArrayList<>();
		homeList = new ArrayList<>();

		leftAdapter = new LeftAdapter(this, menuList);
		lv_menu.setAdapter(leftAdapter);

		rightAdapter = new RightAdapter(this, homeList);
		lv_home.setAdapter(rightAdapter);

		// 左侧分类标题点击事件
		lv_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				leftAdapter.setSelectItem(position);            // 更新左侧位置
				leftAdapter.notifyDataSetInvalidated();        // 更新左侧列表
//				tv_title.setText(menuList.get(position));   	// 更新右侧上方标题
				lv_home.setSelection(showTitle.get(position));  // 到当前分类顶部
			}
		});

		// 右侧商品滑动监听
		lv_home.setOnScrollListener(new AbsListView.OnScrollListener() {
			private int scrollState;

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				this.scrollState = scrollState;
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {    // ListView滑动后静止
					return;
				}
				int current = showTitle.indexOf(firstVisibleItem);
//				lv_home.setSelection(current);
				if (currentItem != current && current >= 0) {
					currentItem = current;
//					tv_title.setText(menuList.get(currentItem));
					leftAdapter.setSelectItem(currentItem);
					leftAdapter.notifyDataSetInvalidated();
				}
			}
		});

		lv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
				Toast.makeText(MainActivity.this, position, Toast.LENGTH_SHORT).show();
			}
		});
	}

	/**
	 * 加载数据
	 */
	private void loadData() {
		String json = getJson(this, "category.json");
		CategoryBean categoryBean = JSONObject.parseObject(json, CategoryBean.class);
		for (int i = 0; i < categoryBean.getData().size(); i++) {
			CategoryBean.DataBean dataBean = categoryBean.getData().get(i);
			menuList.add(dataBean.getModuleTitle());
			showTitle.add(i);
			homeList.add(dataBean);
		}
//		tv_title.setText(categoryBean.getData().get(0).getModuleTitle());
		leftAdapter.notifyDataSetChanged();
		rightAdapter.notifyDataSetChanged();
	}

	/**
	 * 得到json文件中的内容
	 */
	public static String getJson(Context context, String fileName) {
		StringBuilder stringBuilder = new StringBuilder();
		//获得assets资源管理器
		AssetManager assetManager = context.getAssets();
		//使用IO流读取json文件内容
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
					assetManager.open(fileName), "utf-8"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

}
