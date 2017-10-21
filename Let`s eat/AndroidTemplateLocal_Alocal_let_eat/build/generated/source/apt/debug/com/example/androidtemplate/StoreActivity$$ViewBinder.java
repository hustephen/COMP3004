// Generated code from Butter Knife. Do not modify!
package com.example.androidtemplate;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class StoreActivity$$ViewBinder<T extends com.example.androidtemplate.StoreActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558562, "field 'leftTv' and method 'onClick'");
    target.leftTv = finder.castView(view, 2131558562, "field 'leftTv'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131558563, "field 'titleTv'");
    target.titleTv = finder.castView(view, 2131558563, "field 'titleTv'");
    view = finder.findRequiredView(source, 2131558564, "field 'rightTv' and method 'onClick'");
    target.rightTv = finder.castView(view, 2131558564, "field 'rightTv'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131558561, "field 'titleLl'");
    target.titleLl = finder.castView(view, 2131558561, "field 'titleLl'");
    view = finder.findRequiredView(source, 2131558572, "field 'imgIv'");
    target.imgIv = finder.castView(view, 2131558572, "field 'imgIv'");
    view = finder.findRequiredView(source, 2131558573, "field 'addressEt'");
    target.addressEt = finder.castView(view, 2131558573, "field 'addressEt'");
    view = finder.findRequiredView(source, 2131558574, "field 'cuisineEt'");
    target.cuisineEt = finder.castView(view, 2131558574, "field 'cuisineEt'");
    view = finder.findRequiredView(source, 2131558575, "field 'priceEt'");
    target.priceEt = finder.castView(view, 2131558575, "field 'priceEt'");
    view = finder.findRequiredView(source, 2131558569, "field 'ratingBar'");
    target.ratingBar = finder.castView(view, 2131558569, "field 'ratingBar'");
    view = finder.findRequiredView(source, 2131558576, "field 'randomBtn' and method 'onClick'");
    target.randomBtn = finder.castView(view, 2131558576, "field 'randomBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131558565, "field 'contentLl'");
    target.contentLl = finder.castView(view, 2131558565, "field 'contentLl'");
  }

  @Override public void unbind(T target) {
    target.leftTv = null;
    target.titleTv = null;
    target.rightTv = null;
    target.titleLl = null;
    target.imgIv = null;
    target.addressEt = null;
    target.cuisineEt = null;
    target.priceEt = null;
    target.ratingBar = null;
    target.randomBtn = null;
    target.contentLl = null;
  }
}
