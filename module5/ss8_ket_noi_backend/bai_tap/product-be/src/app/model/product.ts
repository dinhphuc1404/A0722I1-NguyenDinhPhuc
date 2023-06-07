import {Category} from './category';

export interface Product {
  id?: number;
  code?: string;
  name?: string;
  price?: number;
  description?: string;
  category?: Category;
}
