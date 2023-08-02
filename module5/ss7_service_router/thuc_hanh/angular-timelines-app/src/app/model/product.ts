import {Category} from './category';

export interface Product {
  id?: number;
  name?: string;
  price?: number;
  ngayRaMat?: string;
  ngayNgungSanXuat?: string;
  category?: Category;
}
