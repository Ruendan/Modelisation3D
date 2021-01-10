/**
 * Copyright (c) 2015, 2020 ControlsFX
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *     * Neither the name of ControlsFX, any associated website, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL CONTROLSFX BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package view.buttons;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.StackPane;

/**
 * Basic Skin implementation for the {@link ToggleSwitch}
 */
public class ToggleSwitchSkin extends SkinBase<ToggleSwitch> {
	private final StackPane thumb;	
	private double thumbTarget;
	private final StackPane thumbArea;
	private final Label label;
	private final StackPane labelContainer;
	private final ToggleSwitch toggleSwitch;
	/**
	 * Constructor for all ToggleSwitchSkin instances.
	 *
	 * @param control The ToggleSwitch for which this Skin should attach to.
	 */
	public ToggleSwitchSkin(ToggleSwitch control) {
		super(control);
		
		this.toggleSwitch = control;
		thumb = new StackPane();
		thumbArea = new StackPane();
		label = new Label();
		labelContainer = new StackPane();
       
        label.textProperty().bind(control.textProperty());
        getChildren().addAll(labelContainer, thumbArea, thumb);
        labelContainer.getChildren().addAll(label);
        StackPane.setAlignment(label, Pos.CENTER_LEFT);

        thumb.getStyleClass().setAll("thumb");
        thumbArea.getStyleClass().setAll("thumb-area");

        thumbArea.setOnMouseReleased(event -> mousePressedOnRetardedSwitch(control));
        thumb.setOnMouseReleased(event -> mousePressedOnRetardedSwitch(control));
        control.selectedProperty().addListener((observable, oldValue, newValue) -> {
        	if (newValue.booleanValue() != oldValue.booleanValue())
        		selectedStateChanged();
        });
	}

	private void selectedStateChanged() {
		if (toggleSwitch.isToggle()) {
			setToggle();
		} else {
			setUnToggle();
		}
	}

	private void setUnToggle() {
		thumb.setLayoutX(0.0);
	}

	private void setToggle() {
		thumb.setLayoutX(thumbTarget);	
	}

	private void mousePressedOnRetardedSwitch(ToggleSwitch toggleSwitch) {
		toggleSwitch.setValue(!toggleSwitch.isToggle());
	}


    /**
     * How many milliseconds it should take for the thumb to go from
     * one edge to the other
     */
	
	@Override
	protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
		final double thumbWidth = snapSize(thumb.prefWidth(-1));
		final double thumbHeight = snapSize(thumb.prefHeight(-1));
		thumb.resize(thumbWidth, thumbHeight);
		
		final double thumbAreaY = snapPosition(contentY);
		final double thumbAreaWidth = snapSize(thumbArea.prefWidth(-1));
		final double thumbAreaHeight = snapSize(thumbArea.prefHeight(-1));

		thumbArea.resize(thumbAreaWidth, thumbAreaHeight);
		thumbArea.setLayoutX(contentWidth - thumbAreaWidth);
		thumbArea.setLayoutY(thumbAreaY);

		labelContainer.resize(contentWidth - thumbAreaWidth, thumbAreaHeight);
		labelContainer.setLayoutY(thumbAreaY);

		thumb.setLayoutX(thumbArea.getLayoutX());
		thumb.setLayoutY(thumbAreaY + (thumbAreaHeight - thumbHeight) / 2);

		thumbTarget = thumbAreaWidth - thumbWidth;

		thumb.setTranslateX(toggleSwitch.isToggle() ? thumbTarget : 0.0);
	}


	@Override protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
		return leftInset + label.prefWidth(-1) + thumbArea.prefWidth(-1) + rightInset;
	}

	@Override protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
		return topInset + Math.max(thumb.prefHeight(-1), label.prefHeight(-1)) + bottomInset;
	}

	@Override protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
		return leftInset + label.prefWidth(-1) + 20 + thumbArea.prefWidth(-1) + rightInset;
	}

	@Override protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
		return topInset + Math.max(thumb.prefHeight(-1), label.prefHeight(-1)) + bottomInset;
	}

	@Override
	protected double computeMaxWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
		return toggleSwitch.prefWidth(height);
	}

	@Override
	protected double computeMaxHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
		return toggleSwitch.prefHeight(width);
	}

}