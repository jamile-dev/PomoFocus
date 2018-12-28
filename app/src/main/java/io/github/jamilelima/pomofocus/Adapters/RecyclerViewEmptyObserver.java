package io.github.jamilelima.pomofocus.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerViewEmptyObserver  extends RecyclerView.AdapterDataObserver {

  private View emptyView;
  private RecyclerView recyclerView;

  public RecyclerViewEmptyObserver(RecyclerView recyclerView, View view) {
    this.recyclerView = recyclerView;
    this.emptyView = view;
  }

  private void checkIfEmpty() {
    if (emptyView != null && recyclerView.getAdapter() != null) {
      boolean emptyViewVisible = recyclerView.getAdapter().getItemCount() == 0;
      if (emptyViewVisible == true) {
        emptyView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
      } else {
        emptyView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
      }
    }
  }

  @Override
  public void onChanged() {
    super.onChanged();
    checkIfEmpty();
  }

  @Override
  public void onItemRangeInserted(int positionStart, int itemCount) {
    super.onItemRangeInserted(positionStart, itemCount);
    checkIfEmpty();
  }

  @Override
  public void onItemRangeChanged(int positionStart, int itemCount) {
    super.onItemRangeChanged(positionStart, itemCount);
    checkIfEmpty();
  }

  @Override
  public void onItemRangeRemoved(int positionStart, int itemCount) {
    super.onItemRangeRemoved(positionStart, itemCount);
    checkIfEmpty();
  }

}
