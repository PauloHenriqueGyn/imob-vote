export class Login {
    constructor(
        public email?: string,
        public senha?: string,
        public token?: string
    ) {}

    static fromJson(jsonData: any): Login {
      return Object.assign(new Login(), jsonData);
  }
}
