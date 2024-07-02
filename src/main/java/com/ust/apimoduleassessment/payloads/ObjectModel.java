package com.ust.apimoduleassessment.payloads;

public class ObjectModel {
		public long obj_id;
		public String obj_name;
		public int mod_year;
		public long mod_price;
		public String mod_mode;
		public String mod_size;
		
		public void ObjectModels()
		{
			
		}
		public long getObj_id() {
			return obj_id;
		}
		public void setObj_id(long obj_id) {
			this.obj_id = obj_id;
		}
		public String getObj_name() {
			return obj_name;
		}
		public void setObj_name(String obj_name) {
			this.obj_name = obj_name;
		}
		public int getMod_year() {
			return mod_year;
		}
		public void setMod_year(int mod_year) {
			this.mod_year = mod_year;
		}
		public long getMod_price() {
			return mod_price;
		}
		public void setMod_price(long mod_price) {
			this.mod_price = mod_price;
		}
		public String getMod_mode() {
			return mod_mode;
		}
		public void setMod_mode(String mod_mode) {
			this.mod_mode = mod_mode;
		}
		public String getMod_size() {
			return mod_size;
		}
		public void setMod_size(String mod_size) {
			this.mod_size = mod_size;
		}
		@Override
		public String toString() {
			return "ObjectModel [obj_id=" + obj_id + ", obj_name=" + obj_name + ", mod_year=" + mod_year
					+ ", mod_price=" + mod_price + ", mod_mode=" + mod_mode + ", mod_size=" + mod_size
					+ ", getObj_id()=" + getObj_id() + ", getObj_name()=" + getObj_name() + ", getMod_year()="
					+ getMod_year() + ", getMod_price()=" + getMod_price() + ", getMod_mode()=" + getMod_mode()
					+ ", getMod_size()=" + getMod_size() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}
		public ObjectModel(long obj_id, String obj_name, int mod_year, long mod_price, String mod_mode,
				String mod_size) {
			super();
			this.obj_id = obj_id;
			this.obj_name = obj_name;
			this.mod_year = mod_year;
			this.mod_price = mod_price;
			this.mod_mode = mod_mode;
			this.mod_size = mod_size;
		}
		
		
		
		
		
}
