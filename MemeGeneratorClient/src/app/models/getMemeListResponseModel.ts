export class MemeListResponseModel {
    memeList: MemeModel[] = [];
    memecaptionList: MemeCaptionModel[] = [];
}

export class MemeCaptionModel {
    caption: string | undefined;
    guid: string | undefined;
}

export class MemeModel {
    fileName: string | undefined;
    guid: string | undefined;
    user: UserModel | undefined;
}

export class UserModel {
    firstName: string | undefined;
    lastName: string | undefined;
    guid: string | undefined;
}