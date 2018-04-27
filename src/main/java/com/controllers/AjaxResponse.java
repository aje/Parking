package com.controllers;

import java.util.List;

public class AjaxResponse {

	public AjaxResponse() {
		// TODO Auto-generated constructor stub
	}
	
	private boolean status;
	private String msg;
	private String redirect;
	private List result;
	
	public void setStatus (boolean status) { this.status = status;};
	public boolean getStatus () { return status;};
	public void setResult (List result) { this.result = result;};
	public List getResult () { return result;};
	public void setMsg (String msg) { this.msg = msg;};
	public String getMsg () { return msg;};
	public void setRedirect (String redirect) { this.redirect = redirect;};
	public String getRedirect () { return redirect;};
}
