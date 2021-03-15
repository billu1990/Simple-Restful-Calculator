/**
 * This object rapresent the result obtained from webservice
 */
export class Result{
    public result: number;
    public error: boolean;
    public message: string;
    public history: any;

    constructor(result: number, error: boolean,history, message ?: string,){
        this.result = result;
        this.error = error;
        this.message = message;
        this.history = history;
    }
}