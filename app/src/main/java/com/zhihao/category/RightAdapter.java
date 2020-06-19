package com.zhihao.category;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * 右侧ListView的适配器
 */
public class RightAdapter extends BaseAdapter {

	private Context context;
	private List<CategoryBean.DataBean> foodDatas;

	RightAdapter(Context context, List<CategoryBean.DataBean> foodDatas) {
		this.context = context;
		this.foodDatas = foodDatas;
	}

	@Override
	public int getCount() {
		if (foodDatas != null) {
			return foodDatas.size();
		} else {
			return 10;
		}
	}

	@Override
	public Object getItem(int position) {
		return foodDatas.size();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item_home, null);
			convertView.setTag(new ViewHold(convertView));
		}
		initializeViews((ViewHold) convertView.getTag(), foodDatas.get(position));
		return convertView;
	}

	@SuppressLint("SetTextI18n")
	private void initializeViews(ViewHold holder, CategoryBean.DataBean dataBean) {
		List<CategoryBean.DataBean.DataListBean> dataList = dataBean.getDataList();
		RightItemAdapter adapter = new RightItemAdapter(context, dataList);
		holder.blank.setText("——" + dataBean.getModuleTitle() + "——");
		holder.gridView.setAdapter(adapter);
		adapter.setOnItemListener(new RightItemAdapter.OnItemListener() {

			@Override
			public void onItemClick(View view, CategoryBean.DataBean.DataListBean object) {
				Toast.makeText(context, object.getTitle(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private static class ViewHold {
		private GridViewForScrollView gridView;
		private TextView blank;

		ViewHold(View view) {
			gridView = view.findViewById(R.id.gridView);
			blank = view.findViewById(R.id.blank);
		}
	}


}
