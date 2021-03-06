/*
 * Copyright (C) 2014 Alejandro Rodriguez Salamanca.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.alexrs.cervantes.ui.recyclerview.viewholder;

import android.graphics.Typeface;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import me.alexrs.cervantes.R;
import me.alexrs.cervantes.core.data.Meaning;
import me.alexrs.cervantes.core.utils.Truss;
import me.alexrs.recyclerviewrenderers.viewholder.RenderViewHolder;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public class MeaningViewHolder extends RenderViewHolder<Meaning> {

  @InjectView(R.id.tv_meaning) TextView textView;

  public MeaningViewHolder(View itemView) {
    super(itemView);
    ButterKnife.inject(this, itemView);
  }

  @Override public void onBindView(Meaning meaning) {

    Truss t = new Truss();
    if (meaning.getMeta() != null) {
      t.pushSpan(new StyleSpan(Typeface.BOLD_ITALIC)).append(meaning.getMeta()).popSpan();
    }
    t.append(" ").append(meaning.getMeaning());

    textView.setText(t.build());
  }
}
