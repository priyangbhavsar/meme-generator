import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { iconPosition } from 'src/app/models/enums/globalEnums';
import * as _ from 'lodash';

@Component({
  selector: 'app-explore-meme',
  templateUrl: './explore-meme.component.html',
  styleUrls: ['./explore-meme.component.scss']
})
export class ExploreMemeComponent implements OnInit {
  iconPosition = iconPosition
  isLiked = true
  actionDone = false
  imageSrc = '../../../assets/images/sample_meme_2.jpg'
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  downloadImage(): void {
    var a = document.createElement('a');
    a.href = this.imageSrc;
    a.download = String(_.last(this.imageSrc.split('/')));
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
  }

  toggleLike(isLiked: boolean) {
    this.isLiked = isLiked;
    this.actionDone = true
  }
}
