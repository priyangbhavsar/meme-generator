import { DashboardComponent } from './../dashboard/dashboard.component';
import { CommonService } from './../../services/common.service';
import { APIService } from './../../services/api.service';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { iconPosition } from 'src/app/models/enums/globalEnums';
import * as _ from 'lodash';
import { MemeCaptionModel, MemeListResponseModel, MemeModel } from 'src/app/models/getMemeListResponseModel';
import  * as htmlToImage from 'html-to-image'
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-explore-meme',
  templateUrl: './explore-meme.component.html',
  styleUrls: ['./explore-meme.component.scss']
})
export class ExploreMemeComponent implements OnInit {
  iconPosition = iconPosition
  isLiked = true
  actionDone = false
  imageSrc: string | undefined = ''
  memeList: MemeModel[] = []
  memeCaptionList: MemeCaptionModel[] = []
  defaultPageNumber = 1
  defaultPageSize = 3
  currentIndex = 0
  fileBaseUrl = 'http://localhost:8080/meme/files/'
  memeHeader: string = ''
  editModeEnabled = false
  @ViewChild("imageContainer")
  private imageElement : ElementRef | undefined; 
  public Editor = ClassicEditor

  constructor(private apiService: APIService, private commonService: CommonService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getMoreMeme()
  }

  downloadImage(): void {
    this.commonService.componentLoading.next(true)
    if (this.imageElement) {
      htmlToImage.toJpeg(this.imageElement.nativeElement as HTMLElement).then(dataUrl => {
        var a = document.createElement('a');
        a.href = dataUrl;
        a.download = String(_.last(this?.imageSrc?.split('/')));
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
      this.commonService.componentLoading.next(false)
      })
    }
  }

  toggleLike(isLiked: boolean) {
    this.isLiked = isLiked;
    this.actionDone = true
  }

  changeMeme(isNext: boolean) {
    if (isNext) {
      this.currentIndex++;
      if (_.isUndefined(_.get(this.memeList, this.currentIndex))) {
        this.defaultPageNumber++;
        this.getMoreMeme()
      } else {
        this.updateimageAndHeader()
      }
    } else {
      this.currentIndex--;
      this.updateimageAndHeader()
    }
  }

  getMoreMeme() {
    this.apiService.sendGetRequest<MemeListResponseModel>(`/meme/getMemeList?pageNumber=${this.defaultPageNumber}&pageSize=${this.defaultPageSize}`)
      .subscribe((data: MemeListResponseModel) => {
        this.memeList = this.memeList.concat(_.get(data, 'memeList', this.memeList))
        this.memeCaptionList = this.memeCaptionList.concat(_.get(data, 'memecaptionList', []))
        this.updateimageAndHeader()
      })
  }

  updateimageAndHeader() {
    this.imageSrc = this.fileBaseUrl + this.memeList[this.currentIndex].fileName
    this.commonService.componentLoading.next(true)
    this.memeHeader = _.get(this.memeCaptionList, [this.currentIndex, 'caption'], '')
  }

  onImageLoad() {
    this.commonService.componentLoading.next(false)
  }

  openSettingsDialog() {
    this.dialog.open(DashboardComponent, {
      width: '800px'
    })
  }
}
