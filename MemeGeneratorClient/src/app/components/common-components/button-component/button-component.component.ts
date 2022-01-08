import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
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

  @Output() clickItemEvent = new EventEmitter<boolean>();
  ngOnInit(): void {
  }

  buttonClicked(event: Event | null = null) {
    if (event) { event.stopPropagation(); }
    this.clickItemEvent.emit(true);
  }
}
