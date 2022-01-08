import { CommonService } from './../../../services/common.service';
import { Component, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.scss']
})
export class LoaderComponent implements OnInit, OnDestroy {

  constructor(private commonService: CommonService) { }

  loaderEnabled = false
  commonServiceSubscription: any

  ngOnInit(): void {
    this.commonServiceSubscription = this.commonService.getLoader().subscribe((data: boolean) => {
      console.log('loading ... ')
      this.loaderEnabled = data
    })
  }

  ngOnDestroy(): void {
    if (this.commonServiceSubscription) {
      this.commonServiceSubscription.unsubscribe()
    }
  }
}
