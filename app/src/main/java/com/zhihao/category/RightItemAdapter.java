package com.zhihao.category;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 商品条目适配器
 */
public class RightItemAdapter extends BaseAdapter {

	private Context context;
	private List<CategoryBean.DataBean.DataListBean> foodDatas;
	private OnItemListener onItemListener;

	public RightItemAdapter(Context context, List<CategoryBean.DataBean.DataListBean> foodDatas) {
		this.context = context;
		this.foodDatas = foodDatas;
	}

	public void setOnItemListener(OnItemListener onItemListener) {
		this.onItemListener = onItemListener;
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
			convertView = View.inflate(context, R.layout.item_home_category, null);
			convertView.setTag(new ViewHold(convertView));
		}
		initializeViews((ViewHold) convertView.getTag(), foodDatas.get(position));
		return convertView;
	}

	@SuppressLint("SetTextI18n")
    private void initializeViews(ViewHold viewHold, final CategoryBean.DataBean.DataListBean subcategory) {
		viewHold.tv_name.setText(subcategory.getTitle());
		Uri uri = Uri.parse(subcategory.getImgURL());
		viewHold.iv_icon.setImageURI(uri);
		viewHold.tv_yuan.setText("￥" + subcategory.getYuan());
		viewHold.tv_xian.setText("￥" + subcategory.getXian());
		viewHold.tv_yuan.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);  // 添加删除线
		viewHold.ll_item.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onItemListener.onItemClick(view, subcategory);
			}
		});
	}

	private static class ViewHold {
		private TextView tv_name;
		private TextView tv_yuan;
		private TextView tv_xian;
		private SimpleDraweeView iv_icon;
		private LinearLayout ll_item;

		ViewHold(View view) {
			tv_name = view.findViewById(R.id.item_home_name);
			tv_xian = view.findViewById(R.id.item_tv_xian);
			tv_yuan = view.findViewById(R.id.item_tv_yuan);
			iv_icon = view.findViewById(R.id.item_album);
			ll_item = view.findViewById(R.id.ll_item);
		}
	}

	public interface OnItemListener {
		void onItemClick(View view, CategoryBean.DataBean.DataListBean object);
	}

}
