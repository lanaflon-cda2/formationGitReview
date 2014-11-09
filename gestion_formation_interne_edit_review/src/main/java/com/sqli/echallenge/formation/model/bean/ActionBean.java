/**
 * 
 */
package com.sqli.echallenge.formation.model.bean;

import com.sqli.echallenge.formation.model.Action;

/**
 * @author Mouad
 *
 */
public class ActionBean {
	private Boolean checked;
	private Action action;
	
	public ActionBean(Boolean checked, Action action) {
		this.checked = checked;
		this.action = action;
	}

	public ActionBean() {
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
	
}
