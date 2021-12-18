import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor() { }

  img: any
  canvas: HTMLCanvasElement | null = null;
  ctx: CanvasRenderingContext2D | null = null;
  text_title: string = "";
  textX: number = 20
  textY: number = 20
  canvasProperties = {
    width: 0,
    height: 0,
    margin_top: 0,
    margin_bottom: 0,
    get imageHight(): number {
      return this.height - this.margin_top - this.margin_bottom
    },
    font_color: 'white',
    max_height: 300
  }

  ngOnInit(): void {
    var imageLoader: any = document.getElementById('imageLoader');
    imageLoader.addEventListener('change', this.handleImage, false);
    this.canvas = <HTMLCanvasElement>document.getElementById('imageCanvas');
    this.ctx = this.canvas?.getContext('2d');
    this.img = new Image();
    this.img.crossOrigin = "anonymous";
    this.DrawPlaceholder();
    if (this.canvas) {
      this.canvas.style.border = "5px solid black"
    }
    // window.addEventListener('load', DrawPlaceholder)
  }


  DrawOverlay() {
    this.ctx?.drawImage(this.img, 0, this.canvasProperties.margin_top, this.canvasProperties.width, this.canvasProperties.imageHight);
    if (this.ctx) {
      this.ctx.fillStyle = 'rgba(0, 0, 0, 0)';
      this.ctx.fillRect(0, 0, this.canvasProperties.width, this.canvasProperties.height);
    }
  }


  DrawPlaceholder() {
    this.img.src = 'https://unsplash.it/400/400/?random';
    // this.img.onload = function () {
    //   this.DrawOverlay();
    //   this.DrawText();
    //   this.DynamicText()
    // };
  }

  DrawText() {
    if (this.ctx) {
      console.log('this.canvasProperties.top_background_color', this.canvasProperties.font_color)
      this.ctx.fillStyle = this.canvasProperties.font_color;
      this.ctx.textBaseline = 'middle';
      this.ctx.font = "50px 'Montserrat'";
      this.ctx.fillText(this.text_title, this.textX, this.textY);
    }
  }


  DynamicText(event: any = null) {
    this?.ctx?.clearRect(0, 0, this.canvasProperties.width, this.canvasProperties.height);
    this.DrawOverlay();
    this.DrawText();
  }

  handleImage(e: any) {
    var reader = new FileReader();
    try {
      reader.readAsDataURL(e.target.files[0])
      reader.onload = (event: any) => {
        const image: HTMLImageElement = new Image();
        var src: any = "";
        image.onload = () => {
          if (this.canvas && this.canvasProperties) {
            this.setCanvasProperties(image)
            this.ctx = this.canvas.getContext('2d');
            if (this.ctx) {
              this.ctx.drawImage(image, 0, this.canvasProperties.margin_top, this.canvasProperties.width, this.canvasProperties.imageHight);
            }
            image.style.position = "absolute";
            image.style.top = this.canvasProperties.margin_top.toString();
          }
        }
        src = event.target.result;
        image.src = event.target.result;
        this.canvas = <HTMLCanvasElement>document.getElementById('imageCanvas');
        this.canvas.classList.add("show");
        if (this.canvas && this.canvasProperties) {
          this.canvasProperties.width = this.canvas.width
          this.canvasProperties.height = this.canvas.height + this.canvasProperties.margin_top
        }
        this.img = image
        this.text_title = ""
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
      this.canvasProperties.width = this.canvas.width = image.width;
      this.canvasProperties.height = this.canvas.height = image.height;
      this.ctx.drawImage(image, 0, this.canvasProperties.margin_top);
    }
    image.src = event.target.result;
    src = event.target.result;
    if (this.canvas) {
      this.canvas.classList.add("show");
    }
    this.img = image
    this.DrawOverlay();
    this.DrawText();
    this.DynamicText();
  }


  convertToImage() {
    window.open(this.canvas?.toDataURL('png'));
  }

  canvasClicked(event: any) {
    this.textX = event.clientX - event.target.offsetLeft
    this.textY = event.clientY - event.target.offsetTop
  }

  setCanvasProperties(image: any) {
    if (this.canvas) {
      // this.canvasProperties.height = this.canvas.height =  (image.height + this.canvasProperties.margin_top);
      // this.canvasProperties.width = this.canvas.width =  image.width ;
      image.width = this.canvasProperties.width = this.canvas.width;
      this.canvasProperties.height = this.canvas.height = image.height =
        (image.height > this.canvasProperties.max_height + this.canvasProperties.margin_top
           ? this.canvasProperties.max_height + this.canvasProperties.margin_top : image.height + this.canvasProperties.margin_top);
    }
  }
}
