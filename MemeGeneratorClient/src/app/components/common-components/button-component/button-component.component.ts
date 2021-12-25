import { Component, Input, OnInit } from '@angular/core';
import { iconPosition } from 'src/app/models/enums/globalEnums';

@Component({
  selector: 'app-button-component',
  templateUrl: './button-component.component.html',
  styleUrls: ['./button-component.component.scss']
})
export class ButtonComponentComponent implements OnInit {

  constructor() { }

  @Input('buttonText')
  buttonText: string | undefined

  @Input('iconPath')
  iconPath: string | undefined

  @Input()
  iconPosition: number = iconPosition.LEET

  @Input()
  rotate: boolean = false
  ngOnInit(): void {
  }

}
