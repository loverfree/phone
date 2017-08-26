package com.newer.phone.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017年8月19日 下午3:50:13
 * 
 * 商品表的实体类--PRODUCT
 * p_id:商品id	
 * p_name:商品名
 * p_import:商品进价
 * p_price:商品售价
 * p_stock:商品库存
 * p_sale:商品销量
 * p_info:商品描述信息
 * p_status:商品状态 0=下架 1=上架
 * barnd:商品品牌对象
 * reviews:商品的所有评论信息
 * carts:包含该商品的所有购物车
 * p_os:商品于所有订单关联的所有对象
 * images:商品的所有图片
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer p_id;
	private String p_name;
	private BigDecimal p_import;
	private BigDecimal p_price;
	private Integer p_stock;
	private Integer p_sale;
	private String p_info;
	private Integer p_status;
	private Brand brand;
	private List<Review> reviews;
	private List<Cart> carts;
	private List<P_O> p_os;
	private List<Image> images;
	private String p_image;

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public BigDecimal getP_import() {
		return p_import;
	}

	public void setP_import(BigDecimal p_import) {
		this.p_import = p_import;
	}

	public BigDecimal getP_price() {
		return p_price;
	}

	public void setP_price(BigDecimal p_price) {
		this.p_price = p_price;
	}

	public Integer getP_stock() {
		return p_stock;
	}

	public void setP_stock(Integer p_stock) {
		this.p_stock = p_stock;
	}

	public Integer getP_sale() {
		return p_sale;
	}

	public void setP_sale(Integer p_sale) {
		this.p_sale = p_sale;
	}

	public String getP_info() {
		return p_info;
	}

	public void setP_info(String p_info) {
		this.p_info = p_info;
	}

	public Integer getP_status() {
		return p_status;
	}

	public void setP_status(Integer p_status) {
		this.p_status = p_status;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public List<P_O> getP_os() {
		return p_os;
	}

	public void setP_os(List<P_O> p_os) {
		this.p_os = p_os;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}

	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_import=" + p_import + ", p_price=" + p_price
				+ ", p_stock=" + p_stock + ", p_sale=" + p_sale + ", p_info=" + p_info + ", p_status=" + p_status
				+ ", images=" + images +  ", p_image=" + p_image+ ", brand=" + brand.getB_id()+" ]";
	}
	
	

}
