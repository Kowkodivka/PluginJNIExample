use jni::JNIEnv;

use jni::objects::{JClass, JString};

use jni::sys::jstring;

#[no_mangle]
pub extern "system" fn Java_ru_kowkodivka_mindustry_RustBridge_hello<'local>(
    mut env: JNIEnv<'local>,
    class: JClass<'local>,
    input: JString<'local>,
) -> jstring {
    let input: String = env
        .get_string(&input)
        .expect("Couldn't get java string!")
        .into();

    let output = env
        .new_string(format!("Hello, {}!", input))
        .expect("Couldn't create java string!");

    output.into_raw()
}
