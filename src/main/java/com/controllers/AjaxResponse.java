package com.controllers;

import java.util.List;

public class AjaxResponse {

	public AjaxResponse() {
		// TODO Auto-generated constructor stub
	}
	
	private boolean status;
	private String msg;
	private String redirect;
	private Object result;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
