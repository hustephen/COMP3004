// Generated code from Butter Knife. Do not modify!
package com.example.androidtemplate;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainNewActivity$$ViewBinder<T extends com.example.androidtemplate.MainNewActivity> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131558566, "field 'distanceSp'");
    target.distanceSp = finder.castView(view, 2131558566, "field 'distanceSp'");
    view = finder.findRequiredView(source, 2131558567, "field 'cuisineSp'");
    target.cuisineSp = finder.castView(view, 2131558567, "field 'cuisineSp'");
    view = finder.findRequiredView(source, 2131558568, "field 'priceSp'");
    target.priceSp = finder.castView(view, 2131558568, "field 'priceSp'");
    view = finder.findRequiredView(source, 2131558569, "field 'ratingBar'");
    target.ratingBar = finder.castView(view, 2131558569, "field 'ratingBar'");
    view = finder.findRequiredView(source, 2131558570, "field 'registerBtn' and method 'onClick'");
    target.registerBtn = finder.castView(view, 2131558570, "field 'registerBtn'");
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
    target.distanceSp = null;
    target.cuisineSp = null;
    target.priceSp = null;
    target.ratingBar = null;
    target.registerBtn = null;
    target.contentLl = null;
  }
}
