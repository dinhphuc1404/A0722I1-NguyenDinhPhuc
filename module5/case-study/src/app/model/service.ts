import {RentalType} from './rentalType';

export interface Service {
  idService?: string;
  nameService?: string;
  dienTichService?: number;
  soTangService?: number;
  soNguoiToiDa?: number;
  chiPhiThue?: number;
  rentalType?: RentalType;
  trangThai?: string;
}
