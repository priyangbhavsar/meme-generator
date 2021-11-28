import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor() { }

  img: any
  canvas: HTMLCanvasElement | any;
  ctx: any;
  text_title: string = "";
  textX: number = 0
  textY: number = 0

  ngOnInit(): void {
    var imageLoader: any = document.getElementById('imageLoader');
    imageLoader.addEventListener('change', this.handleImage, false);
    this.canvas = document.getElementById('imageCanvas');
    console.log(this.canvas)
    this.ctx = this.canvas.getContext('2d');
    this.img = new Image();
    this.img.crossOrigin = "anonymous";
    this.DrawPlaceholder();
    // window.addEventListener('load', DrawPlaceholder)
  }


  DrawPlaceholder() {
    this.img.src = 'https://unsplash.it/400/400/?random';
    // this.img.onload = function () {
    //   this.DrawOverlay();
    //   this.DrawText();
    //   this.DynamicText()
    // };
  }

  DrawOverlay() {
    this.ctx.drawImage(this.img, 0, 0);
    this.ctx.fillStyle = 'rgba(0, 0, 0, 0)';
    this.ctx.fillRect(0, 0, this.canvas.width, this.canvas.height);
  }

  DrawText() {
    this.ctx.fillStyle = "white";
    this.ctx.textBaseline = 'middle';
    this.ctx.font = "50px 'Montserrat'";
    this.ctx.fillText(this.text_title, this.textX, this.textY);
  }


  DynamicText(event: any = null) {
    console.log('keyup event')
    this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);
    this.DrawOverlay();
    this.DrawText();
    if (event) {
      this.text_title = event.target.value;
    }
    this.ctx.fillText(this.text_title, this.textX, this.textY);
  }

  handleImage(e: any) {
    var reader = new FileReader();
    try {
      reader.readAsDataURL(e.target.files[0])
      reader.onload = (event: any) => {
        console.log('reader onload')
        var image: any = "";
        var src: any = "";

        image = new Image();
        image.onload = () => {
          this.canvas.width = image.width;
          this.canvas.height = image.height;
          this.ctx = this.canvas.getContext('2d');
          this.ctx.drawImage(image, 0, 0);
          console.log('image onload')
        }
        image.src = event.target.result;
        src = event.target.result;
        this.canvas = document.getElementById('imageCanvas');
        console.log(this.canvas)
        this.canvas.classList.add("show");
        this.img = image
        this.text_title = ""
        // this.DrawOverlay();
        // this.DrawText();
        // this.DynamicText();
      }
    } catch (err) {
      console.log('error', err)
    }
  }

  initializeImage(event: any) {
    var image: any = "";
    var src: any = "";

    image = new Image();
    image.onload = function () {
      this.canvas.width = image.width;
      this.canvas.height = image.height;
      this.ctx.drawImage(image, 0, 0);
    }
    image.src = event.target.result;
    src = event.target.result;
    this.canvas.classList.add("show");
    this.img = image
    this.DrawOverlay();
    this.DrawText();
    this.DynamicText();
  }


  convertToImage() {
    window.open(this.canvas.toDataURL('png'));
  }

  canvasClicked(event: any) {
    this.textX = event.clientX - event.target.offsetLeft
    this.textY = event.clientY - event.target.offsetTop
    console.log('assigned')
  }

  // document.getElementById('download').onclick = function download() {
  //   convertToImage();
  // }
}
