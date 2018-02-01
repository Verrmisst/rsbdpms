package cn.net.inlink.vo;

import org.apache.xmlbeans.impl.store.Public2;

/**
 * 字典实体
 * @author Yz
 *
 */
public class Dictionary {
	//id
	private Integer id;
	
	//名称
	private String dictName;
	
	//类型
	private String dictType;

	public Dictionary(){}
	
	public Dictionary(Integer id, String dictName, String dictType) {
		super();
		this.id = id;
		this.dictName = dictName;
		this.dictType = dictType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	@Override
	public String toString() {
		return "Dictionary [id=" + id + ", dictName=" + dictName
				+ ", dictType=" + dictType + "]";
	}
	
}
