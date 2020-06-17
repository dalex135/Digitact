import { FormsData } from '../../model/forms-data.model';

/**
 * Names of the individual "pages" (form steps) shown in the application form.
 *
 * When routing to a page (or referencing a page in another way),
 * you should always use this enum and not hard-code the values as they might change later.
 */
export enum ApplicationStep {
  BasicInformation = 'basic-information',
  ContactInformation = 'contact-information',
  ProfilePicture = 'profile-picture',
  Documents = 'documents',
  EducationInformation = 'education-information',
  FieldDesignationPreference = 'field-designation-preference',
  KeyCompetencies = 'key-competencies',
  AdditionalInformation = 'additional-information',
  Submit = 'submit',
}

/**
 * All of the possible steps as an array.
 */
export const ApplicationStepsArr = Object.values(ApplicationStep);

/**
 * Information about all Steps.
 * Currently, it just includes the info whether the respective Step should be used for progress calculation.
 * (And if this is the case, the name of the form item is also provided.)
 */
export const ApplicationStepsConfig: ApplicationStepsConfig = {
  [ApplicationStep.BasicInformation]: {
    useForProgressCalculation: true,
    formItemName: 'basicInfo',
  },
  [ApplicationStep.ContactInformation]: {
    useForProgressCalculation: true,
    formItemName: 'contactInfo',
  },
  [ApplicationStep.ProfilePicture]: {
    useForProgressCalculation: true,
    formItemName: 'profilePicture',
  },
  [ApplicationStep.Documents]: {
    useForProgressCalculation: false,
  },
  [ApplicationStep.EducationInformation]: {
    useForProgressCalculation: true,
    formItemName: 'educationInfo',
  },
  [ApplicationStep.FieldDesignationPreference]: {
    useForProgressCalculation: true,
    formItemName: 'fieldDesignationInfo',
  },
  [ApplicationStep.KeyCompetencies]: {
    useForProgressCalculation: true,
    formItemName: 'keyCompetencies',
  },
  [ApplicationStep.AdditionalInformation]: {
    useForProgressCalculation: false,
  },
  [ApplicationStep.Submit]: {
    useForProgressCalculation: false,
  },
};

type ApplicationStepsConfig = {
  [key in ApplicationStep]: ApplicationStepsConfigItem;
};
/**
 * A single Steps Config item.
 */
type ApplicationStepsConfigItem =
  | ConfigItemWithProgress
  | ConfigItemWithoutProgress;
/**
 * An item that should be used for progress calculation.
 */
interface ConfigItemWithProgress {
  useForProgressCalculation: true;
  /**
   * The name of the form item in our large FormGroup.
   */
  formItemName: keyof FormsData;
}
interface ConfigItemWithoutProgress {
  useForProgressCalculation: false;
}
