import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {VatTuService} from '../../service/vat-tu.service';
import {VatTu} from '../../model/vat-tu';
import { jsPDF } from 'jspdf';
import html2canvas from 'html2canvas';
@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {
  @ViewChild('htmlContent') htmlContent!: ElementRef;
  @ViewChild('pdfViewer') pdfViewer!: ElementRef;
  vatTus: VatTu[];
  vatTu: VatTu;
  constructor(private route: ActivatedRoute, public vatTuService: VatTuService) { }

  ngOnInit(): void {
    this.findAllSelect();
  }

  calculateTotalPrice() {
    let totalPrice = 0;
    for (const item of this.vatTus) {
      totalPrice += item.soLuong * item.donGia;
    }
    return totalPrice;
  }
  findAllSelect() {
    this.vatTus = this.vatTuService.findAllSelect();
  }

  getProduct(id: number) {
    this.vatTu = this.vatTuService.findById(id);
  }

  removeProduct() {
    this.vatTu = this.vatTuService.findById(this.vatTu.id);
    this.vatTuService.deleteById(this.vatTu.id);
    this.vatTus = this.vatTuService.findAllSelect();
  }

  // printPDF() {
  //   this.findAllSelect();
  //   const doc = new jsPDF();
  //   let y = 10;
  //   doc.text('List', 10, y);
  //   y += 10;
  //   this.vatTus.forEach(vatTu => {
  //     const row = `${vatTu.maVatTu} - ${vatTu.name}- ${vatTu.soLuong} - ${vatTu.donGia} -
  //    ${vatTu.donGia * vatTu.soLuong} ${vatTu.ghiChu}`;
  //     doc.text(row, 10, y);
  //     y += 10;
  //   });
  //   doc.save('sample.pdf');
  // }
  printPDF() {
    const doc = new jsPDF();
    html2canvas(this.htmlContent.nativeElement).then((canvas) => {
      const contentDataURL = canvas.toDataURL('image/png');
      doc.addImage(contentDataURL, 'PNG', 20, 20, doc.internal.pageSize.getWidth() - 10, 0);
      doc.save('file.pdf');
    });
  }
}
