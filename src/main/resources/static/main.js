
// import FileExcel from "./filemod/fileExcel";


// import {FileExcel} from "./filemod/fileExcel";

// import File1 from "./filemod/fileExcel";

const { PageHeader } = antd;
const MyApp = () => {

    return (
        <div>
            <PageHeader
                style={{
                    border: '1px solid rgb(235, 237, 240)',
                }}
                onBack={() => null}
                title="Title"
                subTitle="This is a subtitle"
            />
            {/*<File1 />*/}
        </div>
    )
}


const container = document.getElementById("root");
ReactDOM.render(<MyApp />,container);