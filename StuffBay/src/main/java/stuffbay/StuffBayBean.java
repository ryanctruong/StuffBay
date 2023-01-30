package stuffbay;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="stuffBayBean")
@RequestScoped
public class StuffBayBean {
	private String msg;

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@PostConstruct
	private void init() {

		msg = "Welcome to StuffBay! Auction For Free!!";
	}

}