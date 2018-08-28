package com.douglas.demospringmongo.domain;

public class IPAddress {
	
	private String ip;
	private String dns;
	private String mask;
	private String gateway;
	
	public IPAddress(String ip, String dns, String mask, String gateway) {
		super();
		this.ip = ip;
		this.dns = dns;
		this.mask = mask;
		this.gateway = gateway;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	
	
}
